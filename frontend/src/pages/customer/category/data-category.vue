<template>
  <v-row>
  
    <v-col v-for="(song, index) in songs" :key="index" cols="6" sm="4" lg="2">
      <album-card-2 :song="song"></album-card-2>
    </v-col>
  </v-row>
</template>

<script>
import AlbumCard2 from "@/components/customer/AlbumCard2.vue";
import { mapGetters } from "vuex";
export default {
  components: { AlbumCard2 },
  created() {},
  computed: {
    ...mapGetters("category", ["songs"]),
  },
};
</script>

<style></style>
