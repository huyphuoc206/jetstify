<template>
  <div>
    <v-card-title class="text-h5 font-weight-black">About</v-card-title>
    <v-card-text class="contentAbout">
      {{ showText }}

      <v-btn small v-if="about.length > 200" text @click="handleBtnClick">{{
        toggleAboutText
      }}</v-btn>
    </v-card-text>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import { trucateText } from "@/utils/text-utils";
export default {
  props: ["about"],
  name: "PodcastAbout",

  computed: {
    ...mapGetters("podcast", ["toggleAbout"]),
    toggleAboutText() {
      return this.toggleAbout ? "Show less" : "See more";
    },

    showText() {
      if (this.about.length < 200 || this.toggleAbout) {
        return this.about;
      } else {
        return this.trucateText(this.about, 200);
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
