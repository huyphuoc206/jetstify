<template>
   <v-row>
          <v-col cols="auto">
            <your-episodes></your-episodes>
          </v-col>
          <v-col
            cols="6"
            sm="4"
            lg="2"
            v-for="(podcast, index) in podcasts"
            :key="index"
          >
            <podcast-cart :podcast="podcast"></podcast-cart>
          </v-col>
        </v-row>
</template>

<script>
import yourEpisodes from './your-episodes.vue'
import {   mapGetters } from 'vuex';
import PodcastCart from '@/components/customer/PodcastCart.vue';
export default {
  components: { yourEpisodes, PodcastCart },
methods: {
    
  },
  computed: {
    ...mapGetters("podcasts", ["podcasts"]),
  },
  
}
</script>

<style>

</style>