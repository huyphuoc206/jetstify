<template>
  <v-row class="grow-column">
    <v-col class="py-0" cols="4" sm="4">
      <v-row class="align-center" style="height: 150px">
        <v-col cols="auto">
          <v-img
            class="elevation-10"
            src="https://i.pinimg.com/736x/58/ff/a6/58ffa6ad3cf14f853068dce774329839.jpg"
            width="56"
            height="56"
          ></v-img>
        </v-col>
        <v-col class="pl-1 text-truncate">
          <span>
            <router-link
              class="body-2 font-weight-medium ma-0 link_text white--text"
              :to="{
                name: 'Album',
                params: {
                  id: 1,
                },
              }"
            >
              The Moon Song - Film Version
            </router-link>
          </span>
          <br />
          <span class="caption font-weight-light">
            <router-link
              class="ma-0 link_text lime--text"
              :to="{
                name: 'Artist',
                params: {
                  id: 1,
                },
              }"
            >
              Scarlett Johansson </router-link
            >,
            <router-link
              class="ma-0 link_text lime--text"
              :to="{
                name: 'Artist',
                params: {
                  id: 1,
                },
              }"
            >
              Joaquin Phoenix
            </router-link>
          </span>
        </v-col>
        <v-col cols="">
          <v-btn icon>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-col>
    <v-col class="d-flex justify-center align-center" cols="4" sm="4">
      <v-row class="d-block" :style="{}">
        <div
          v-for="icon of [
            'shuffle',
            'skip-previous',
            'play-circle',
            'skip-next',
            'repeat',
          ]"
          :key="icon"
          class="mx-3 d-inline  "
        >
          <v-btn
            icon
            :small="icon != 'play-circle'"
            :x-large="icon == 'play-circle'"
          >
            <v-icon v-text="`mdi-${icon}`"></v-icon>
          </v-btn>
        </div>
        <v-col
          align-center
          cols="12"
          sm="5"
          :style="{}"
          class="align-center justify-center"
        >
          <v-app-bar flat>
            <span class="caption text-9xl ml-n14">01:44</span>
            <v-slider value="25" color="orange" class="mt-6"></v-slider>
            <span class="caption text-9xl">04:30</span>
          </v-app-bar>
        </v-col>
        <!-- <div class="ml-5 caption hidden-sm-and-down">-4:53</div> -->
      </v-row>
    </v-col>
    <v-col class="d-flex justify-end align-center" cols="4" sm="4">
      <v-btn :to="{ name: 'Queue' }" icon>
        <v-icon>mdi-playlist-play</v-icon>
      </v-btn>
    </v-col>

    <!-- component 2 -->
    <!-- <v-div class="d-flex flex-column justify-space-between align-center">
      <v-row>
        <v-col cols="12" sm="2"></v-col>
        <v-col
          cols="12"
          sm="8"
          style="
            position: absolute;
            bottom: 0;
            margin-left: auto;
            margin-right: auto;
            left: 0;
            right: 0;
            text-align: center;
          "
        >
          <v-card tile color="#1E2337" dark>
            <v-progress-linear
              :value="50"
              class="my-0"
              height="3"
            ></v-progress-linear>
            <v-row>
              <v-col cols="12" sm="2">
                <v-img
                  src="https://cdn.vuetifyjs.com/images/lists/4.jpg"
                  max-height="40"
                  max-width="40"
                  class="mt-4 ml-2"
                ></v-img>
              </v-col>
              <v-col cols="12" sm="1">
                <h6 class="mt-5 ml-n16 grey--text text--ligten-1">
                  La liberté<br />
                  <span class="grey--text text--darken-2">Soolking</span>
                </h6>
              </v-col>
              <v-col cols="12" sm="2">
                <v-btn icon class="ml-n14 mt-4">
                  <v-icon>mdi-rewind</v-icon>
                </v-btn>
                <v-btn icon class="mt-4">
                  <v-icon color="orange">mdi-pause</v-icon>
                </v-btn>
                <v-btn icon class="mt-4">
                  <v-icon>mdi-fast-forward</v-icon>
                </v-btn>
              </v-col>
              <v-col cols="12" sm="5">
                <v-app-bar flat color="#1E2337">
                  <span class="caption text-9xl ml-n14">01:44</span>
                  <v-slider value="25" color="orange" class="mt-6"></v-slider>
                  <span class="caption text-9xl">04:30</span>
                </v-app-bar>
              </v-col>
              <v-col cols="12" sm="1">
                <v-btn icon class="mt-4">
                  <v-icon small>fas fa-random</v-icon>
                </v-btn>
              </v-col>
              <v-col cols="12" sm="1">
                <v-btn icon class="mt-4">
                  <v-icon small>fas fa-undo</v-icon>
                </v-btn>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-div> -->
  </v-row>
</template>

<script>
export default {
  name: "Player",
};
</script>
<style lang="scss">
.link_text {
  text-decoration: none;
}
</style>
