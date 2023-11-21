import { StyleSheet, View, Image } from "react-native";
import { Text, TextInput, Button, Appbar } from "react-native-paper";
import * as React from "react";
import CardHistoric from "./CardHistoric/CardHistoric";

export default function Historic({ navigation }) {
  const _handleSearch = () => console.log("Searching");

  return (
    <View style={styles.container}>
      <Text style={styles.text}>Ganhos e Despesas </Text>
      <CardHistoric />
      <CardHistoric />
      <CardHistoric />
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
  
    
  },
  text: {
    fontSize: 20,
    fontWeight: "bold",
    marginBottom: 20,
  },
});
