import { StyleSheet, View, Image } from "react-native";
import { Text, TextInput, Button } from "react-native-paper";
import { useState } from "react";
import Logo from "../../../assets/logo.png";
export default function Login({ navigation }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    navigation.navigate("Main");
    /*
    if (email === "thiagoaciole7@gmail.com" && password === "1234") {
      
      setEmail("");
      setPassword("");
    } else {
      alert("Credenciais inválidas");
    }*/
  };

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
