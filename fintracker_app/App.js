import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import Login from "./src/page/Login/login";
import Main from "./src/page/main";
import Notification from "./src/page/Notifications/notifications";
import AppBar from "./src/components/AppBar/appbar";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import { PaperProvider } from "react-native-paper";
const Stack = createStackNavigator();

export default function App() {
  return (
    <PaperProvider>
      <NavigationContainer>
        <Stack.Navigator
          initialRouteName="login"
          screenOptions={{
            headerShown: false,
          }}
        >
          <Stack.Screen name="Login" component={Login} />
          <Stack.Screen name="Main" component={Main} />
          <Stack.Screen name="Notification" component={Notification} />
        </Stack.Navigator>
      </NavigationContainer>
    </PaperProvider>
  );
}
