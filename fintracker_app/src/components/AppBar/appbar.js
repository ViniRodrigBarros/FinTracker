import { StyleSheet, View, Image } from "react-native";
import { Text, TextInput, Button, Appbar } from "react-native-paper";
import * as React from "react";
import Logo from "../../../assets/icon.png";

export default function AppBar({ navigation }) {
  return (
    <View>
      <Appbar.Header>
        <Appbar.Action icon="bell" onPress={navigation} />
        <Appbar.Content />
        <Image
          source={Logo}
          style={{
            width: 40,
            height: 40,
            resizeMode: "contain",
            marginRight: 10,
          }}
        />
      </Appbar.Header>
    </View>
  );
}
