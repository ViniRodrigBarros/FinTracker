import * as React from "react";
import { Avatar, Card, IconButton, Text } from "react-native-paper";

export default function CardHistoric({title, description, value}) {
  const iconChange = () => {
    if (title == "Ganho") {
      return "arrow-up";
    } else {
      return "arrow-down";
    }
  };
  const colorChange = () => {
    if (title == "Ganho") {
      return "green";
    } else {
      return "red";
    }
  };

  const BackgroundColor = () => {
    if (title == "Ganho") {
      return "#DDF0DA";
    } else {
      return "#F0DADA";
    }
  };

  return (
    <Card style={{ marginBottom: 20 }}>
      <Card.Title
        title={title}
        subtitle={description}
        left={(props) => (
          <Avatar.Icon
            {...props}
            icon={iconChange()}
            color={colorChange()}
            style={{ backgroundColor: BackgroundColor()	 }}
          />
        )}
        right={(props) => (
          <Text style={{ margin: 20, fontSize: 16, fontWeight: "bold" }}>
            R$ {value}
          </Text>
        )}
      />
    </Card>
  );
}
