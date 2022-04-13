<template>
  <v-row>
    <v-col cols="12" sm="6" md="4" lg="2" v-for="i of 6" :key="i">
      <v-hover v-slot:default="{ hover }">
        <v-card class="common-card" flat height="300" width="250">
          <v-card-text>
            <v-img
              height="200"
              class="elevation-10"
              style="border-radius: 50%"
              src="https://i.ytimg.com/vi/FN7ALfpGxiI/maxresdefault.jpg"
            >
            </v-img>
            <div
              :style="{
                position: 'absolute',
                right: '20px',
                bottom: '85px',
                cursor: 'auto',
              }"
              v-show="hover"
            >
              <v-icon color="green" size="60">mdi-play-circle</v-icon>
            </div>
          </v-card-text>

          <v-card-text class="pt-0">
            <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
              <router-link
                class="white--text text-decoration-none"
                :to="{
                  name: 'Artist',
                  params: {
                    id: 1,
                  },
                }"
                >Army of Bones</router-link
              >
            </p>
            <p class="caption font-weight-light mb-4 text-truncate">Artist</p>
          </v-card-text>
        </v-card>
      </v-hover>
    </v-col>
  </v-row>
</template>
