import { StyleSheet, View, Image } from "react-native";
import { TextInput, Button } from "react-native-paper";
import { useState } from "react";
import Logo from "../../../assets/logo.png";
import axios from "axios";
import qs from "qs"; // Importe o módulo qs

export default function Login({ navigation }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function handleLogin() {
    try {
      const response = await axios.post(
        "http://localhost:8080/users/login",
        qs.stringify({
          email: email,
          password: password,
        }),
        {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
        }
      );

      if (response.status == 200) {
    
        navigation.navigate("Main");
      } else {

        console.error("Falha na autenticação");
      }
    } catch (error) {
      console.error("Erro ao tentar autenticar", error);
    }
  }

  return (
    <View style={styles.container}>
      <Image
        source={Logo}
        style={{ width: 300, height: 100, resizeMode: "contain" }}
      />

      <TextInput
        textContentType="emailAddress"
        mode="outlined"
        label="Email"
        placeholder=""
        value={email}
        onChangeText={(text) => setEmail(text)}
      />
      <TextInput
        secureTextEntry
        mode="outlined"
        label="Senha"
        placeholder=""
        value={password}
        onChangeText={(text) => setPassword(text)}
      />

      <Button
        mode="contained"
        onPress={handleLogin}
        buttonColor="#4169E1"
        style={{ marginTop: 20 }}
      >
        Entrar
      </Button>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingHorizontal: 20,
    justifyContent: "center",
  },
});
