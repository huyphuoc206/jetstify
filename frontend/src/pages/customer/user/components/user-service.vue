<template>
  <v-container fluid>
    <v-menu transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3" dark v-bind="attrs" v-on="on">...</v-btn>
      </template>
      <v-list>
        <v-list-item @click="handleEdit">Edit profile</v-list-item>
      </v-list>
    </v-menu>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "UserService",

  computed: {
    ...mapGetters("user", ["toggleDialog"]),
  },

  methods: {
    ...mapActions("user", ["setToggleDialog"]),

    handleEdit() {
      this.setToggleDialog();
    },
  },
};
</script>

<style lang="scss"></style>
