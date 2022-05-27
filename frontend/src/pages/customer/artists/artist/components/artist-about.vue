<template>
  <v-container>
    <h1 class="headline font-weight-bold">About</h1>

    <v-dialog v-model="dialog" width="700px">
      <template v-slot:activator="{ on, attrs }">
        <v-card
          class="mt-2 thumbnailArtist"
          :img="thumbnailAbout" 
          height="516"
          width="1032"
          v-bind="attrs"
          v-on="on"
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
      </template>

      <v-card outlined>
        <v-btn absolute fab right icon dark @click="dialog = false">
          <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-carousel :show-arrows="false" hide-delimiter-background>
          <v-carousel-item v-for="(item, i) in images" :key="i">
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
                v-for="(social, i) in socials"
                :key="i"
                :href="social.link"
                target="_blank"
              >
                <v-card-subtitle>
                  <v-icon class="ml-2">{{ social.icon }}</v-icon>
                  {{ social.name }}
                </v-card-subtitle>
              </v-btn>
            </v-col>

            <v-col class="right">
              <v-card-text
                >{{artist.info}}</v-card-text
              >

              <v-card-text
                >https://www.viberate.com/artist/son-tung-m-tp</v-card-text
              >

              <v-card-text>
                <v-avatar>
                  <img
                    src="https://i.scdn.co/image/ab6761610000f178c48716f91b7bf3016f5b6fbe"
                    alt="Son Tung"
                  /> 
                </v-avatar>

                Posted By Sơn Tùng M-TP
              </v-card-text>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
export default {
  props:["socials", "artist","images"],
  name: "ArtistAbout",

  data: () => ({
    thumbnails: [
      {
        img: "https://i.scdn.co/image/ab6761670000ecd4676e49a89cefa298dc3558f4",
      },
      {
        img: "https://th.bing.com/th/id/OIP.UOxkfqh5bdAdqka3KSWUyAHaEK?pid=ImgDet&rs=1",
      },
      {
        img: "https://th.bing.com/th/id/OIP.6DFU43oDDEZv6WuvhfuD7AHaEK?pid=ImgDet&rs=1",
      },
      {
        img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
      },
      {
        img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
      },
      {
        img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
      },
    ],
     

   
    dialog: false,
  }),

  computed: {
    thumbnailAbout() {
      return this.images[0].link;
    }
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
