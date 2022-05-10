<template>
  <v-app-bar dark app>
    <v-row align="center" justify="space-between">
      <v-col cols="auto">
        <v-btn class="mx-2 d-in" fab dark small color="black">
          <v-icon dark> mdi-chevron-left </v-icon>
        </v-btn>
        <v-btn class="mx-2" fab dark small color="black">
          <v-icon dark> mdi-chevron-right </v-icon>
        </v-btn>
      </v-col>
      <!-- Handle input search on AppBar. page Search -->
      <!-- start -->
      <v-row v-if="checkInputSearch()">
        <v-col class="py-0" cols="auto">
          <v-text-field
            clearable
            filled
            hide-details
            label="Search for Artists, songs, or podcasts"
            prepend-inner-icon="mdi-magnify"
            rounded
          ></v-text-field>
        </v-col>
      </v-row>
      <!-- end --> 
      <v-row v-if="checkMenuLibrary()">
        <v-col class="py-0" cols="auto">
          <router-link
            active-class="font-weight-bold"
            class="white--text subtitle-2"
            :to="{ name: 'Home' }"
            >FEATURED</router-link
          >
        </v-col>
        <v-col class="py-0" cols="auto">
          <router-link
            active-class="font-weight-bold"
            class="white--text subtitle-2"
            :to="{ name: 'Genres' }"
            >GENRES & MOODS</router-link
          >
        </v-col>
        <v-col class="py-0" cols="auto">
          <router-link
            active-class="font-weight-bold"
            class="white--text subtitle-2"
            :to="{ name: 'Discover' }"
            >DISCOVER</router-link
          >
        </v-col>
      </v-row>

      <!--  -->
      <v-col cols="auto" class="align-end">
        <v-btn rounded color="black" dark> UPGRADE </v-btn>

        <v-btn v-if="isAuthenticated" class="ml-7 mr-5" color="pink" fab dark>
          <v-menu bottom min-width="200px" rounded offset-y>
            <template v-slot:activator="{ on }">
              <v-btn icon x-large v-on="on">
                <v-avatar color="brown" size="48">
                  <span class="white--text text-h5 mt">{{ avatar }}</span>
                </v-avatar>
              </v-btn>
            </template>
            <v-card>
              <v-list-item-content class="justify-center">
                <div class="mx-auto text-center">
                  <!-- <v-avatar color="brown">
                    <span class="white--text text-h5">{{ user.initials }}</span>
                  </v-avatar> -->
                  <h3>{{ fullName }}</h3>
                  <!-- <p class="text-caption mt-1">
                    {{ user.email }}
                  </p> -->
                  <v-divider class="my-3"></v-divider>
                  <v-btn depressed rounded text> Account Settings </v-btn>
                  <v-divider class="my-3"></v-divider>
                  <v-btn depressed rounded text @click="handleLogout()"> Logout </v-btn>
                </div>
              </v-list-item-content>
            </v-card>
          </v-menu>
        </v-btn>
        <v-btn v-else :to="{ name: 'Login' }" class="ml-7 mr-5" color="pink" dark> Login </v-btn>
      </v-col>
    </v-row>
  </v-app-bar>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "AppBar",

  data: () => ({
  }),

  computed: {
    ...mapGetters("auth", ["fullName", "isAuthenticated"]),
    avatar() {
      return this.fullName ? this.fullName.charAt(0) : ''; 
    }
  },

  methods: {
    ...mapActions("auth", ["logout"]),

    checkInputSearch() {
      if (this.$route.name === "Search") return true;
      return false;
    },

    checkMenuLibrary() {
      if (this.$route.name === "Collection") return true;
      return false;
    },

    async handleLogout() {
      await this.logout();
    }
  },
  async created() {
    this.checkMenuLibrary();
    this.checkInputSearch();
  },
};
</script>
