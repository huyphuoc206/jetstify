<template>
  <v-row justify="center">
    <v-dialog :value="dialog" max-width="290" @click:outside="handleCancel">
      <!-- <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary" dark v-bind="attrs" v-on="on">
          Open Dialog
        </v-btn>
      </template> -->
      <v-card>
        <v-card-title class="text-h5"> Delete {{ content }} ?</v-card-title>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="handleCancel">
            Cancel
          </v-btn>
          <v-btn color="green darken-1" text @click="handleRemove">
            Delete
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  name: "DialogRemove",
  props: ["dialog", "content", "handleCancel", "handleRemove"],
  data() {
    return {};
  },
};
</script>

<style></style>
