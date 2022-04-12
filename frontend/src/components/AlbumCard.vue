<template>
  <v-row>
    <v-col cols="12" sm="6" md="4" v-for="song of songs" :key="song.name">
      <v-hover v-slot:default="{ hover }" style="cursor: pointer">
        <v-card class="album-card d-flex ma-auto" flat height="90px">
          <v-card class="">
            <v-img
              max-width="100"
              height="100%"
              class="elevation-3"
              :src="song.img"
            >
            </v-img>
          </v-card>

          <v-card-text class="ma-auto">
            <p class="" :style="{ fontSize: '20px' }">
              <router-link
                class="_active white--text"
                :to="{
                  name: 'Album',
                  params: {
                    id: 1,
                  },
                }"
              >
                {{ song.name }}
              </router-link>
            </p>
            <p class="ma-auto">
              {{ song.artist }}
            </p>

            <v-btn
              elevation="2"
              class="ma-auto play_btn"
              :style="{
                position: 'absolute',
                right: '10px',
                bottom: '17px',
                cursor: 'auto',
              }"
              fab
              v-show="hover"
            >
              <v-icon size="70" color="green">mdi-play-circle</v-icon>
            </v-btn>
          </v-card-text>
        </v-card>
      </v-hover>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data: () => ({
    songs: [
      {
        name: "Nơi này có anh",
        artist: "Sơn Tùng MTP",
        img: "https://i.ytimg.com/vi/FN7ALfpGxiI/maxresdefault.jpg",
      },
      {
        name: "Chill Music",
        artist: "",
        img: "https://th.bing.com/th/id/OIP.UOxkfqh5bdAdqka3KSWUyAHaEK?pid=ImgDet&rs=1",
      },
      {
        name: "Có Chàng Trai Viết Lên Cây",
        artist: "Phan Mạnh Quỳnh",
        img: "https://th.bing.com/th/id/OIP.6DFU43oDDEZv6WuvhfuD7AHaEK?pid=ImgDet&rs=1",
      },
      {
        name: "3107",
        artist: "W/n",
        img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
      },
      {
        name: "3107",
        artist: "W/n",
        img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
      },
      {
        name: "3107",
        artist: "W/n",
        img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
      },
    ],
  }),
  name: "AlbumCard",
};
</script>
<style lang="scss">
._active {
  text-decoration: none;
}
.album-card {
  transition: all 0.2s ease-out;
}
.album-card:hover {
  background: rgba(255, 255, 255, 0.3);
}
</style>
