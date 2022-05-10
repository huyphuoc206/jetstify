<template>
  <v-col class="pt-0" cols="12" sm="7" md="8">
    <v-hover
      v-for="(song, index) in songs"
      :key="index"
      v-slot:default="{ hover }"
    >
      <v-list-item link two-line>
        <v-list-item-content class="py-0">
          <v-row class="align-center">
            <v-col class="py-0" cols="auto">
              <v-icon>{{
                hover ? "mdi-play" : "mdi-music-note-outline"
              }}</v-icon>
            </v-col>
            <v-col>
              <v-list-item-title>
                <v-list-item-title>{{ song }}</v-list-item-title>
                <v-list-item-subtitle
                  >The Delano Orchestra</v-list-item-subtitle
                >
              </v-list-item-title>
            </v-col>
            <v-col cols="auto"> 3:49 </v-col>
          </v-row>
        </v-list-item-content>
      </v-list-item>
    </v-hover>
  </v-col>
</template>

<script>
export default {
  name: "Right",
  data: () => ({
    songs: [
      "Intro",
      "Frozn Lake",
      "Kill Me Twice",
      "Say We Are",
      "Bubbles of Soap",
      "Little Girl",
    ],
  }),
};
</script>

<style></style>
