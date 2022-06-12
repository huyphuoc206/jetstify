<template>
  <div>
    <v-card-title class="text-h5 font-weight-black">About</v-card-title>
    <v-card-text class="contentAbout">
      {{ showText }}

      <v-btn small v-if="{assignDefaultValue}.length > 200" text @click="handleBtnClick">{{
        toggleAboutText
      }}</v-btn>
    </v-card-text>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import { trucateText } from "@/utils/text-utils";
export default {
  name: "PodcastAbout",


  computed: {
    ...mapGetters("podcast", ["toggleAbout", "podcastInfo"]),

    assignDefaultValue() {
      return this.podcastInfo.description || '';
    },

    toggleAboutText() {
      return this.toggleAbout ? "Show less" : "See more";
    },

    showText() { 
      if (this.assignDefaultValue.length < 200 || this.toggleAbout) {      
        return this.podcastInfo.description;
      } else {
        return this.trucateText(this.assignDefaultValue, 200);
      }
    },
  },

  methods: {
    ...mapActions("podcast", ["setToggleAbout"]),

    trucateText,

    handleBtnClick() {
      this.setToggleAbout();
    },
  },
};
</script>

<style lang="scss" scoped>
// .contentAbout {
//   color: #b3b3b3;
// }
</style>
