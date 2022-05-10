<template>
   <v-row>
          <v-col cols="auto">
            <your-episodes></your-episodes>
          </v-col>
          <v-col
            cols="6"
            sm="4"
            lg="2"
            v-for="(song, index) in allSong"
            :key="index"
          >
            <podcast-cart :song="song"></podcast-cart>
          </v-col>
        </v-row>
</template>

<script>
import yourEpisodes from './your-episodes.vue'
import { mapActions, mapGetters } from 'vuex';
import PodcastCart from '@/components/PodcastCart.vue';
export default {
  components: { yourEpisodes, PodcastCart },
methods: {
    ...mapActions("songs", ["fetchSong"]),
  },
  computed: {
    ...mapGetters("songs", ["allSong"]),
  },
  async created() {
    await this.fetchSong();
  },
}
</script>

<style>

</style>