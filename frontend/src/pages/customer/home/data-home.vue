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
            <v-btn small text @click="toggleSeeAll(type.key, 'typeSongs')"
              >{{type.isSeeAll ? 'See less' : 'See all'}}</v-btn
            >
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(song, index) in homeDataDisplay[type.key]"
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
            <v-btn small text @click="toggleSeeAll(type.key, 'typePodcasts')"
              >{{type.isSeeAll ? 'See less' : 'See all'}}</v-btn
            >
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(podcast, index) in homeDataDisplay[type.key]"
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
            <v-btn small text @click="toggleSeeAll(type.key, 'typeArtists')"
              >{{type.isSeeAll ? 'See less' : 'See all'}}</v-btn
            >
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(artist, index) in homeDataDisplay[type.key]"
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
import { mapGetters, mapActions } from "vuex";
export default {
  components: { AlbumCard2, PodcastCart, ArtistCard },
  data: () => ({
    typeSongs: [
      { name: "Your shows", type: "", key: "listSongRandom", isSeeAll: false },
      { name: "Song News", type: "", key: "listSongNew", isSeeAll: false },
    ],
    typePodcasts: [
      {
        name: "Podcasts Recommend",
        type: "",
        key: "listPodcastRandom",
        isSeeAll: false,
      },
      {
        name: "Podcasts Many Like",
        type: "",
        key: "listPodcastFollowManyLikes",
        isSeeAll: false,
      },
      {
        name: "Podcasts News",
        type: "",
        key: "listPodcastNew",
        isSeeAll: false,
      },
    ],
    typeArtists: [
      {
        name: "Artists Recommend",
        type: "",
        key: "listArtistRandom",
        isSeeAll: false,
      },
      {
        name: "Artists Many Like",
        type: "",
        key: "listArtistFollowManyLikes",
        isSeeAll: false,
      },
      { name: "Artists News", type: "", key: "listArtistNew", isSeeAll: false },
    ],
  }),
  computed: { ...mapGetters("home", ["homeDataDisplay"]) },

  methods: {
    ...mapActions("home", ["setHomeDataDisplay"]),

    toggleSeeAll(key, type) {
      let isSeeAll;
      switch (type) {
        case "typeSongs": {
          const index = this.typeSongs.findIndex((e) => e.key === key);
          this.typeSongs[index] = {
            ...this.typeSongs[index],
            isSeeAll: !this.typeSongs[index].isSeeAll,
          };
          isSeeAll = this.typeSongs[index].isSeeAll;
          console.log(1);
          break;
        }
        case "typePodcasts": {
          const index = this.typePodcasts.findIndex((e) => e.key === key);
          this.typePodcasts[index] = {
            ...this.typePodcasts[index],
            isSeeAll: !this.typePodcasts[index].isSeeAll,
          };
          isSeeAll = this.typePodcasts[index].isSeeAll;
           console.log(2);
          break;
        }
        case "typeArtists": {
          const index = this.typeArtists.findIndex((e) => e.key === key);
          this.typeArtists[index] = {
            ...this.typeArtists[index],
            isSeeAll: !this.typeArtists[index].isSeeAll,
          };
          isSeeAll = this.typeArtists[index].isSeeAll;
          break;
        }
        default:
          break;
      }
      this.setHomeDataDisplay({ key, isSeeAll });
    },
  },
};
</script>

<style></style>
