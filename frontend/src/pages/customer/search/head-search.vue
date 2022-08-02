<template>
  <v-row v-if="topResult.songId">
    <v-col>
      <v-row class="align-start">
        <v-col sm="4">
          <v-row>
            <v-col>
              <h1 class="headline font-weight-bold">Top result</h1></v-col
            >
          </v-row>
          <v-col>
            <song-list-item
              :song="topResult"
              type="result"
            ></song-list-item
          ></v-col>
        </v-col>

        <v-col v-if="results.length > 0">
          <v-row>
            <v-col>
              <h1 class="headline font-weight-bold">Songs</h1>
            </v-col>
          </v-row>
          <v-col>
            <v-list
              class="pa-0"
              v-for="(song, index) in results"
              :key="index"
            >
              <song-list-item :song="song"></song-list-item>
            </v-list>
          </v-col>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import SongListItem from "@/components/customer/SongListItem.vue";
// import ResultCard from "@/components/customer/ResultCard.vue";
import { mapGetters } from "vuex";
export default {
  name: "HeadSearch",
  components: { SongListItem },
  computed: {
    ...mapGetters("search", ["dataSearch"]),
    topResult() {
      return this.dataSearch["songResponseList"] ? this.dataSearch["songResponseList"][0] : {};
    },

    results() {
      if (!this.dataSearch["songResponseList"] || this.dataSearch["songResponseList"].length <= 1) return [];
      return this.dataSearch["songResponseList"]
        .filter((e) => e.songId !== this.dataSearch["songResponseList"][0].songId)
        .slice(0, 4);
    },
  },
};
</script>

<style></style>
