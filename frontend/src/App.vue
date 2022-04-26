<template>
  <v-app>
    <app-bar />
    <app-navigation />
    <v-main>
      <v-fab-transition>
        <router-view />
      </v-fab-transition>
    </v-main>
    <v-footer class="elevation-10" app fixed style="z-index: 10">
      <app-player/>
    </v-footer>
  </v-app>
</template>

<script>
import AppBar from "@/components/AppBar.vue";
import AppNavigation from "@/components/Navigation.vue";
import AppPlayer from "@/components/Player";
export default {
  name: "App",
  components: {
    AppNavigation,
    AppBar,
    AppPlayer,
  },
  data: () => ({}),
};
</script>
