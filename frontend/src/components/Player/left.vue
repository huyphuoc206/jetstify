<template>
  <v-col class="py-0" cols="4" sm="4">
    <v-row class="align-center" style="height: 100%">
      <v-col cols="auto">
        <v-img
          class="elevation-10 mt-5"
          src="https://i.pinimg.com/736x/58/ff/a6/58ffa6ad3cf14f853068dce774329839.jpg"
          width="60"
          height="60"
        ></v-img>
      </v-col>
      <v-col class="pl-1 text-truncate mt-5">
        <span>
          <router-link
            class="body-2 font-weight-medium ma-0 link_text white--text"
            :to="{
              name: 'Album',
              params: {
                id: 1,
              },
            }"
          >
            The Moon
          </router-link>
        </span>
        <br />
        <span class="caption font-weight-light">
          <router-link
            class="ma-0 link_text lime--text"
            :to="{
              name: 'Artist',
              params: {
                id: 1,
              },
            }"
          >
            Scarlett Johansson
          </router-link>
          <!-- Option if song have 2 singer should 2 link singer -->
        </span>
      </v-col>
      <v-col class="mt-4">
        <v-btn icon>
          <v-icon>mdi-heart-outline</v-icon>
        </v-btn>
      </v-col>
    </v-row>
  </v-col>
</template>

<script>
export default {
  name: "Left",
};
</script>

<style>
.link_text {
  text-decoration: none;
}
</style>
