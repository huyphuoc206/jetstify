<template>
  <v-row>
    <v-col
    
     
    >
      <v-hover style="cursor: pointer">
        <v-card class="common-card" flat height="100%" width="500">
          <v-card-text>
            <v-img
              :style="{
                borderRadius: '5px',
              }"
              width="100"
              height="100"
              class="elevation-3"
              :src="song.thumbnail"
            >
            </v-img>
          </v-card-text>

          <v-card-text class="mt-3 pt-0 ma-auto">
            <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
              <router-link
                class="white--text text-decoration-none"
                :style="{
                    fontSize:'30px'
                    }"
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
            <p class="caption font-weight-light mt-2 mb-4 text-truncate">
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
  props:["song"],
  data: () => ({
    
  }),
};
</script>
<style lang="scss"></style>
