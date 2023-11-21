import { StyleSheet, View, Image } from "react-native";
import { Text, TextInput, Button, Appbar } from "react-native-paper";
import * as React from "react";
export default function Home({ navigation }) {
  const _handleSearch = () => console.log("Searching");

  return (
    <View>
      <Appbar.Header>
        <Appbar.Action icon="credit-card" onPress={() => {}} />
        <Appbar.Content title="Cartões e Contas" />
      </Appbar.Header>
    </View>
  );
}
