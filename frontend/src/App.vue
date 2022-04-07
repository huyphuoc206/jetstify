<template>
  <v-app>
    <app-bar />
    <app-navigation />
    <v-main>
      <v-fab-transition>
        <router-view />
      </v-fab-transition>
    </v-main>
  </v-app>
</template>

<script>
import AppBar from "@/components/AppBar.vue";
import AppNavigation from "@/components/Navigation.vue";
export default {
  name: "App",
  components: {
    AppNavigation,
    AppBar,
  },
  data: () => ({
    //
  }),
};
</script>