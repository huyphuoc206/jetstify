<template>
  <v-container>
    <h1 class="headline font-weight-bold">About</h1>
    <v-card
      @click="dialog = true"
      class="mt-2 thumbnailArtist"
      :img="artist.photos[0].link"
      height="516"
      width="1032"
    >
      <v-card-title class="white--text d-block aboutArtist">
        <v-card-text class="font-weight-black"
          >489.439 người nghe hàng tháng</v-card-text
        >
        <v-card-text class="font-weight-black">
          Nguyễn Thanh Tùng (born 5 July 1994 in Thái Bình Province), known
          professionally as Sơn Tùng M-TP is a Vietnamese singer-songwriter.
          Most of his songs, such as "Cơn mưa ngang qua" (The Rain of
          Love)</v-card-text
        >
      </v-card-title>
    </v-card>
    <v-dialog v-model="dialog" width="700px">
      <v-card outlined>
        <v-btn absolute fab right icon dark @click="dialog = false">
          <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-carousel :show-arrows="false" hide-delimiter-background>
          <v-carousel-item v-for="(item, i) in artist.photos" :key="i">
            <v-img
              contain
              lazy-src="https://picsum.photos/id/11/10/6"
              height="100%"
              :src="item.link"
            ></v-img>
          </v-carousel-item>
        </v-carousel>

        <v-container>
          <v-row>
            <v-col class="left">
              <v-card-title class="display-1 font-weight-black"
                >3.274.065</v-card-title
              >
              <v-card-subtitle class="grey--text">Follower</v-card-subtitle>

              <v-card-title class="display-1 font-weight-black"
                >490.359</v-card-title
              >
              <v-card-subtitle class="grey--text"
                >Monthly Listeners</v-card-subtitle
              >

              <v-btn
                class="mt-2"
                width="170px"
                :href="artist.facebook"
                target="_blank"
              >
                <v-card-subtitle>
                  <v-icon class="ml-2">mdi-facebook</v-icon>
                  Facebook
                </v-card-subtitle>
              </v-btn>
              <v-btn
                class="mt-2"
                width="170px"
                :href="artist.instagram"
                target="_blank"
              >
                <v-card-subtitle>
                  <v-icon class="ml-2">mdi-instagram</v-icon>
                  Instagram
                </v-card-subtitle>
              </v-btn>
              <v-btn
                class="mt-2"
                width="170px"
                :href="artist.twitter"
                target="_blank"
              >
                <v-card-subtitle>
                  <v-icon class="ml-2">mdi-twitter </v-icon>
                  Twitter
                </v-card-subtitle>
              </v-btn>
            </v-col>

            <v-col class="right">
              <v-card-text>{{ artist.info }}</v-card-text>

          

              <v-card-text>
                <v-avatar>
                  <img
                    :src="artist.thumbnail"
                    alt="Son Tung"
                  />
                </v-avatar>

                Posted By {{artist.nickName}}
              </v-card-text>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "ArtistAbout",
  computed: {
    ...mapGetters("artists", ["artist", "photos"]),
  },
  data: () => ({
    dialog: false,
  }),
  created() {
    console.log(this.photos);
  },
};
</script>

<style lang="scss" scoped>
.left {
  flex: none;
  width: 250px;
}

.right {
  flex: 1 1 0;
}

// .closeDialog {
//   // position: absolute;
//   right: 0;
// }

.aboutArtist {
  padding-top: 250px;
}

.thumbnailArtist {
  transition: transform 0.2s;
}

.thumbnailArtist:hover {
  transform: scale(1.03);
}
</style>
