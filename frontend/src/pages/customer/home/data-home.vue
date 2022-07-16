<template>
  <div>
    <v-row v-for="type of typeSongs" :key="type.name">
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">{{ type.name }}</h1>
            <p class="body-2">Inspired by your recent activity.</p>
          </v-col>

          <v-col cols="auto">
            <v-btn small text>See all</v-btn>
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(song, index) in home[type.key]"
            :key="index"
          >
            <album-card-2 :song="song"></album-card-2>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <!-- podcast -->
     <v-row v-for="type of typePodcasts" :key="type.name">
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">{{ type.name }}</h1>
            <p class="body-2">Inspired by your recent activity.</p>
          </v-col>

          <v-col cols="auto">
            <v-btn small text>See all</v-btn>
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(podcast, index) in home[type.key]"
            :key="index"
          >
            <podcast-cart :podcast="podcast"></podcast-cart>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <!-- Type artists -->
    <v-row v-for="type of typeArtists" :key="type.name">
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">{{ type.name }}</h1>
            <p class="body-2">Inspired by your recent activity.</p>
          </v-col>

          <v-col cols="auto">
            <v-btn small text>See all</v-btn>
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(artist, index) in home[type.key]"
            :key="index"
          >
            <artist-card :artist="artist"></artist-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import AlbumCard2 from "@/components/customer/AlbumCard2.vue";
import PodcastCart from "@/components/customer/PodcastCart.vue";
import ArtistCard from "@/components/customer/ArtistCard.vue";
import {  mapGetters } from "vuex";
export default {
  components: { AlbumCard2, PodcastCart,ArtistCard },
  data: () => ({
    typeSongs: [
      { name: "Your shows", type: "", key:"listSongRandom" },
      { name: "Song News", type: "", key:"listSongNew" },
      
    ],
      typePodcasts: [
      { name: "Podcasts Recommend", type: "",key:"listPodcastRandom" },
      { name: "Podcasts Many Like", type: "", key:"listPodcastFollowManyLikes" },
       { name: "Podcasts News", type: "",key:"listPodcastNew" },
      
    ],
      typeArtists: [
      { name: "Artists Recommend", type: "", key:"listArtistRandom" },
      { name: "Artists Many Like", type: "",key:"listArtistFollowManyLikes" },
      { name: "Artists News", type: "", key:"listArtistNew" },
      
    ],
  }),
  computed: { ...mapGetters("home", ["home"]) },
 methods:{
  getDataHome(home){
    const obj = home;
    obj;
    // for(const key of yourArray){
    //   obj[key] = whatever;
    // }
  }
 }

};
</script>

<style></style>
