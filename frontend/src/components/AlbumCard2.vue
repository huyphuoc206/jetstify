<template>
  <v-row>
    <v-col cols="12" sm="4" md="2" v-for="song of songs" :key="song.name">
      <v-hover v-slot:default="{ hover }">
        <v-card class="album-card" flat>
          <v-card-text>
            <v-img max-width="300" class="elevation-3" :src="song.img"> </v-img>
          </v-card-text>

          <v-card-text class="pt-0 ma-auto">
            <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
              <router-link
                :to="{
                  name: 'Album',
                  params: {
                    id: 1,
                  },
                }"
              >
                <p :style="{ fontSize: '20px' }">{{ song.name }}</p>
              </router-link>
            </p>
            <p class="caption font-weight-light mb-4 text-truncate">
              {{ song.artist }}
            </p>

            <div
              style="position: absolute; right: 10px; bottom: 10px"
              v-show="hover"
            >
              <v-icon size="35">mdi-play-circle-outline</v-icon>
            </div>
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
  name: "AlbumCard2",
};
</script>
<style lang="scss"></style>
