import * as React from "react";
import { View, DatePicker } from "react-native";
import {
  Button,
  Dialog,
  Portal,
  Text,
  TextInput,
  RadioButton,
} from "react-native-paper";

const FormsDialog = ({ visible, hideDialog, addEntry }) => {
  const [checked, setChecked] = React.useState("Ganho");
  const [description, setDescription] = React.useState("");
  const [value, setValue] = React.useState();
  const [date, setDate] = React.useState("");

  const handleAddEntry = () => {
    const entry = {
      type: checked,
      description,
      value,
      date,
    };

    addEntry(entry);
    hideDialog();
    setChecked("Ganho");
    setDescription("");
    setValue();
  };

  return (
    <View>
      <Portal>
        <Dialog visible={visible} onDismiss={hideDialog}>
          <Dialog.Title style={{ fontWeight: "bold" }}>
            Adicione Ganhos e Despesas
          </Dialog.Title>
          <Dialog.Content>
            <View>
              <Text style={{ marginBottom: 10 }}>Selecione o tipo</Text>
              <View
                style={{ flexDirection: "row", justifyContent: "space-around" }}
              >
                <View style={{ flexDirection: "row", alignItems: "center" }}>
                  <RadioButton
                    value="Ganho"
                    status={checked === "Ganho" ? "checked" : "unchecked"}
                    onPress={() => setChecked("Ganho")}
                  />
                  <Text>Ganho</Text>
                </View>
                <View style={{ flexDirection: "row", alignItems: "center" }}>
                  <RadioButton
                    value="Despesa"
                    status={checked === "Despesa" ? "checked" : "unchecked"}
                    onPress={() => setChecked("Despesa")}
                  />
                  <Text>Despesa</Text>
                </View>
              </View>
            </View>
            <TextInput
              label="Descrição"
              mode="outlined"
              style={{ marginTop: 10 }}
              value={description}
              onChangeText={(text) => setDescription(text)}
            />
            <TextInput
             
              keyboardType="decimal-pad"
              label="Valor"
              mode="outlined"
              style={{ marginTop: 10 }}
              value={value}
              onChangeText={(text) => setValue(text)}
            />
            <TextInput
              label="Data"
              mode="outlined"
              style={{ marginTop: 10 }}
              value={date}
              onChangeText={(text) => setDate(text)}
            />
          </Dialog.Content>
          <Dialog.Actions style={{ justifyContent: "center", display: "flex" }}>
            <Button
              labelStyle={{
                paddingHorizontal: 8,
                paddingVertical: 4,
                fontSize: 16,
              }}
              mode="text"
              onPress={hideDialog}
            >
              CANCELAR
            </Button>
            <Button
              labelStyle={{
                paddingHorizontal: 8,
                paddingVertical: 4,
                fontSize: 16,
              }}
              mode="contained"
              onPress={handleAddEntry}
            >
              ADICIONAR
            </Button>
          </Dialog.Actions>
        </Dialog>
      </Portal>
    </View>
  );
};

export default FormsDialog;
