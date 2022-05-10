<template>
  <v-col
    class="pa-10 pa-sm-4 py-sm-0 pa-md-8 py-md-0 py-0"
    cols="12"
    sm="5"
    md="4"
  >
    <div>
      <v-hover v-slot:default="{ hover }">
        <v-img
          class="elevation-10"
          src="https://i.scdn.co/image/ab67616d0000b273452b8f1f15311cad1661d6f4"
        >
          <v-overlay absolute opacity="0.5" :value="hover">
            <v-icon size="90">mdi-play-circle-outline</v-icon>
          </v-overlay>
        </v-img>
      </v-hover>
      <div class="text-center mt-4 mb-0">
        <p
          class="headline font-weight-bold ma-0 mb-1"
          style="line-height: 1.5rem"
        >
          A little girl, a little boy, and all the snails they have drawn
        </p>
        <p class="subtitle-1 mb-4">
          <router-link
            :to="{
              name: 'Artist',
              params: {
                id: 1,
              },
            }"
            >The Delano Orchestra</router-link
          >
        </p>

        <p class="caption">2008 • 14 SONGS</p>
      </div>
    </div>
  </v-col>
</template>

<script>
export default {
  name: "Left",
};
</script>

<style></style>
