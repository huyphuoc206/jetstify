<template>
  <v-snackbar
    v-model="show"
    top
    right
    multi-line
    timeout="5000"
    :color="snackbar.color"
  >
    <strong>{{ snackbar.message }}</strong>

    <template v-slot:action="{ attrs }">
      <v-btn x-small text v-bind="attrs" @click="show = false">
        <v-icon> mdi-close </v-icon>
      </v-btn>
    </template>
  </v-snackbar>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  name: "Notification",

  computed: {
    ...mapGetters("global", ["snackbar"]),
    show: {
      get() {
        return this.snackbar.show;
      },

      set() {
        this.closeNotice();
      },
    },
  },

  methods: {
    ...mapActions("global", ["closeNotice"]),
  },
};
</script>