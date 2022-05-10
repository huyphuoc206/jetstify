<template>
  <v-hover v-slot:default="{ hover }" style="cursor: pointer">
    <v-card class="common-card" flat height="250" width="380">
      <v-img
        :style="{
          borderRadius: '5px',
        }"
        width="100%"
        height="100%"
        class="elevation-3"
        :src="s"
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
        <div
          :style="{
            position: 'absolute',
            left: '10px',
            bottom: '10px',
            cursor: 'auto',
          }"
        >
          <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
            <router-link
              class="white--text text-decoration-none"
              :style="{
                fontSize: '30px',
              }"
              :to="{
                name: 'Album',
                params: {
                  id: 1,
                },
              }"
            >
              Your Episodes
            </router-link>
          </p>
          <p class="caption font-weight-light mb-4 text-truncate">1 episode</p>
        </div>
      </v-img>
    </v-card>
  </v-hover>
</template>

<script>
export default {
  props: ["song"],
  data: () => ({}),
  name: "YourEpisodes",
};
</script>
<style lang="scss"></style>
