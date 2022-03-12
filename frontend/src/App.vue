<template>
  <v-app>
    <app-bar app />
    <app-navigation />
    <v-main>
      <v-fade-transition>
        <router-view />
      </v-fade-transition>
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
