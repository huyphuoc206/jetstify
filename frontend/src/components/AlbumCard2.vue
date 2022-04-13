<template>
  <v-row>
    <v-col
      cols="12"
      sm="6"
      md="4"
      lg="2"
      v-for="song of songs"
      :key="song.name"
    >
      <v-hover v-slot:default="{ hover }" style="cursor: pointer">
        <v-card class="common-card" flat height="300" width="250">
          <v-card-text>
            <v-img
              :style="{
                borderRadius: '5px',
              }"
              width="300"
              height="200"
              class="elevation-3"
              :src="song.img"
            >
              <div
                :style="{
                  position: 'absolute',
                  right: '10px',
                  bottom: '10px',
                  cursor: 'auto',
                }"
                v-show="hover"
              >
                <v-icon color="green" size="70">mdi-play-circle</v-icon>
              </div>
            </v-img>
          </v-card-text>

          <v-card-text class="pt-0 ma-auto">
            <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
              <router-link

                class="white--text text-decoration-none"
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
            <p class="caption font-weight-light mb-4 text-truncate">
              {{ song.artist }}
            </p>
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
