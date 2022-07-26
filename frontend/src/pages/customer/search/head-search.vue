<template>
  <v-row>
    <v-col>
      <v-row class="align-start">
        <v-col sm="4">
          <v-row>
            <v-col>
              <h1 class="headline font-weight-bold">Top result</h1></v-col
            >
          </v-row>
          <v-col> <result-card></result-card></v-col>
        </v-col>

        <v-col>
          <v-row>
            <v-col>
              <h1 class="headline font-weight-bold">Songs</h1>
            </v-col>
            <v-col cols="auto">
              <v-btn small text>See all</v-btn>
            </v-col>
          </v-row>
          <v-col>
            <v-list class="pa-0">
              <song-list-item v-for="(song, index) in dataSearch['songResponseList']" :key="index"></song-list-item>
            </v-list>
          </v-col>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import SongListItem from "@/components/customer/SongListItem.vue";
import ResultCard from "@/components/customer/ResultCard.vue";
import { mapGetters } from 'vuex';
export default {
  name: "HeadSearch",
  components: { SongListItem, ResultCard },
    computed: { ...mapGetters("search", ["dataSearch"]) },
};
</script>

<style></style>
