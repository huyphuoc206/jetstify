<template>
  <v-hover v-slot="{ hover }">
    <v-row class="episodeRow">
      <v-row>
        <v-col class="left">
          <div class="thumbnail">
            <v-img
              class="rounded-lg imgThumb no-hover"
              :src="episode.thumbnail"
            ></v-img>
          </div>
        </v-col>
        <v-col class="right">
          <div>
            <div>
              <v-card-title class="title">
                {{ episode.title }}
              </v-card-title>
              <v-menu
                v-if="hover"
                min-width="200px"
                transition="slide-y-transition"
                offset-y
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn class="ml-3 btn" text dark v-bind="attrs" v-on="on">
                    ...
                  </v-btn>
                </template>

                <v-list>
                  <v-list-item v-for="(item, i) in items" :key="i">
                    <v-list-item-title>{{ item.name }}</v-list-item-title>
                  </v-list-item>
                </v-list>
              </v-menu>
            </div>

            <v-card-text class="description">
              {{ trucateText(episode.description, 200) }}
            </v-card-text>
            <div class="bar">
              <v-icon color="white" size="40">mdi-play-circle</v-icon>
              <v-card-text class="time">{{ episode.createAt }}</v-card-text>
              <v-card-text class="time">{{ episode.time }}</v-card-text>

              <div class="barService">
                <v-icon v-if="hover" @click="handleCopyLink" class="ml-2"
                  >fa-solid fa-arrow-up-from-bracket</v-icon
                >

                <v-icon v-if="hover" @click="handleCheck" class="ml-2">{{
                  showIcon
                }}</v-icon>

                <!-- <v-icon v-if="isCheck" @click="handleCheck" class="ml-2 checkIcon"
                >fa-solid fa-circle-check</v-icon
              >
              <v-icon v-else @click="handleCheck" class="ml-2 plusIcon"
                >fa-solid fa-circle-plus</v-icon
              > -->
              </div>
            </div>
          </div>
        </v-col>
      </v-row>
    </v-row>
  </v-hover>
</template>

<script>
import { trucateText } from "@/utils/text-utils";
export default {
  props: ["episode"],
  name: "PodcastEpisode",

  data: () => ({
    items: [
      { name: "Thêm vào danh sách chở", type: "" },
      { name: "Lưu vào tập tin của bạn", type: "" },
      { name: "Xem mô tả tập", type: "" },
    ],

    isCheck: false,
  }),

  computed: {
    showIcon() {
      return this.isCheck
        ? "fa-solid fa-circle-check"
        : "fa-solid fa-circle-plus";
    },
  },

  methods: {
    trucateText,

    handleCheck() {
      this.isCheck = !this.isCheck;
    },

    handleCopyLink() {},
  },
};
</script>

<style lang="scss" scoped>
.thumbnail {
  width: 112px;
  height: 112px;

  & > .imgThumb {
    width: 100%;
    height: 100%;
  }

  & > .no-hover {
    pointer-events: none;
  }
}
.episodeRow {
  margin: 0 16px;
  padding: 16px;
  border-top-style: solid;
  border-color: rgba(255, 255, 255, 0.1);
}

.episodeRow :hover {
  background: grey;
}

.left {
  flex: none;
  width: 112px;
  padding: 0;
}

.right {
  flex: 1 1 0;
  padding: 0;
}

.title {
  padding: 0;
  padding-left: 16px;
  display: inline;
}

.btn {
  float: right;
  border-style: none;
}

.description {
  padding: 0;
  padding-left: 16px;
  margin: 8px 0 16px;
  word-wrap: break-word;
}

.bar {
  display: inline-block;
  padding-left: 16px;
  width: 100%;

  & > .time {
    display: inline;
  }

  & > .barService {
    padding: 5px;
    float: right;
  }
  .show-btns {
    color: rgba(255, 255, 255, 1) !important;
  }
}
</style>
