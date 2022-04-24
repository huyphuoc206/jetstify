<template>
  <v-app>
    <template v-if="isFullscreen">
      <v-main>
        <v-fab-transition>
          <router-view />
        </v-fab-transition>
      </v-main>
    </template>
    <template v-else>
      <app-bar />
      <app-navigation />
      <v-main>
        <v-fab-transition>
          <router-view />
        </v-fab-transition>
      </v-main>
      <v-footer class="elevation-10" app fixed style="z-index: 10">
        <!-- <app-player /> -->
      </v-footer>
    </template>
  </v-app>
</template>

<script>
import AppBar from "@/components/AppBar.vue";
import AppNavigation from "@/components/Navigation.vue";
// import AppPlayer from "./components/Player.vue";
export default {
  name: "App",

  components: {
    AppNavigation,
    AppBar,
    // AppPlayer,
  },

  computed: {
    isFullscreen() {
      if (!this.$route.name) return false;
      return this.$route.meta.fullscreen;
    }
  },
};
</script>
