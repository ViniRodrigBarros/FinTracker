import { StyleSheet, View, Image } from "react-native";
import { Text, TextInput, Button, Appbar } from "react-native-paper";
import * as React from "react";

export default function Notification({ navigation }) {
  const goBack = () => navigation.goBack();
  return (
    <View>
      <Appbar.Header>
        <Appbar.BackAction onPress={goBack} />
        <Appbar.Content title="Notificações" />
      </Appbar.Header>
    </View>
  );
}
