import { BottomNavigation } from "react-native-paper";
import * as React from "react";

import Home from "./Home/home";
import Investiment from "./Investimentos/investiment";
import Account from "./Account/account";
import Card from "./Card/card";
import AppBar from "../components/AppBar/appbar";

export default function Main({ navigation }) {
  const [index, setIndex] = React.useState(0);
  const [routes] = React.useState([
    {
      key: "home",
      title: "Home",
      focusedIcon: "home",
      unfocusedIcon: "home-outline",
    },
    { key: "card", title: "Cartões", focusedIcon: "credit-card" },
    { key: "invest", title: "Investimentos", focusedIcon: "bank" },
    { key: "account", title: "Conta", focusedIcon: "account" },
  ]);

  const renderScene = BottomNavigation.SceneMap({
    home: Home,
    card: Card,
    invest: Investiment,
    account: Account,
  });

  return (
    <>
      {index === 0 ? (
        <AppBar navigation={() => navigation.navigate("Notification")} />
      ) : (
        ""
      )}
      <BottomNavigation
        navigationState={{ index, routes }}
        onIndexChange={setIndex}
        renderScene={renderScene}
      />
    </>
  );
}
