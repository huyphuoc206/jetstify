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

      <!--  -->
      <v-col cols="auto" class="align-end">
   

        <v-btn
          v-if="isAuthenticated"
          class="ml-7 mr-5"
          :color="avatar ? null : 'brown'"
          fab
          dark
        >
          <v-menu bottom min-width="200px" rounded offset-y>
            <template v-slot:activator="{ on }">
              <v-btn icon x-large v-on="on">
                <v-avatar color="brown" size="48">
                  <v-img v-if="avatar" :src="avatar" alt="avatar"></v-img>
                  <span v-else class="white--text text-h5 mt">{{
                    defaultAvatar
                  }}</span>
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
                  <v-btn depressed rounded text to="/user">
                    Account Settings
                  </v-btn>
                   <v-divider class="my-3"></v-divider>
                      <v-btn depressed rounded text to="/artist-setting">
                    Artist Settings
                  </v-btn>
                   <v-divider class="my-3"></v-divider>
                      <v-btn depressed rounded text to="/podcast-setting">
                    Podcast Settings
                  </v-btn>
                  <v-divider class="my-3"></v-divider>
                  <v-btn depressed rounded text @click="handleLogout()">
                    Logout
                  </v-btn>
                </div>
              </v-list-item-content>
            </v-card>
          </v-menu>
        </v-btn>
        <v-btn
          v-else
          :to="{ name: 'Login' }"
          class="ml-7 mr-5"
          color="pink"
          dark
        >
          Login
        </v-btn>
      </v-col>
    </v-row>
  </v-app-bar>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "AppBar",

  computed: {
    ...mapGetters("auth", ["fullName", "avatar", "isAuthenticated"]),

    defaultAvatar() {
      return this.fullName ? this.fullName.charAt(0) : "";
    },
  },

  methods: {
    ...mapActions("auth", ["logout"]),

    checkInputSearch() {
      if (this.$route.name === "Search") return true;
      return false;
    },

    async handleLogout() {
      await this.logout();
      this.$router.go(this.$router.currentRoute);
    },
  },
  async created() {
    this.checkInputSearch();
  },
};
</script>
