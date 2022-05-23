<template>
  <v-container>
    <h1 class="headline font-weight-bold">Popular</h1>
    <v-row class="mt-2" v-for="song in songs" :key="song.id">
      <v-col>
        <artist-song :song="song" />
      </v-col>
    </v-row>
    <v-row class="mb-2">
      <v-btn>See more</v-btn>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import artistSong from "./artist-song.vue";
export default {
  components: { artistSong },
  name: "SongListItem2",
  data() {
    return {};
  },

  computed: { ...mapGetters("artists", ["songs"]) },
  methods: {
    ...mapActions("artists", ["getSongs"]),
    async getSong({ id }) {
      await this.getSongs(id);
    },
  },
  async created() {
    const flag = this.$route.path;
    const id = flag.split("/")[2];
    await this.getSong({ id });
  },
};
</script>

<style lang="scss" scoped></style>
