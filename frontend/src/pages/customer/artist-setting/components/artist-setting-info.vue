<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img height="320px">
          <v-card class="card d-flex">
            <v-avatar class="profile" color="brown" size="200">
              <v-img v-if="checkAvatar" :src="avatar"></v-img>
              <span v-else class="white--text text-h1 mt font-weight-regular">{{
                avatarDefault
              }}</span>
            </v-avatar>
            <v-card-title class="white--text d-block titleArtits">
              <h3 class="mb-7 font-weight-bold">Profile</h3>
              <h1 class="display-3 font-weight-bold" @click="handleEdit">
                {{ artistInfo.nickName }}
              </h1>
            </v-card-title>
          </v-card>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "ArtisSettingInfo",

  computed: {
    ...mapGetters("artistSetting", ["artistInfo"]),

    checkAvatar() {
      const photo = this.artistInfo.photos || [];

      return photo.length === 0 || !photo[0].link ? false : true;
    },

    avatar() {
      return this.artistInfo.photos[0].link;
    },

    avatarDefault() {
      return this.artistInfo.nickName ? this.artistInfo.nickName.charAt(0) : "";
    },
  },

  methods: {
    ...mapActions("artistSetting", ["getInfoArtist", "setToggleDialog"]),

    handleEdit() {
      this.setToggleDialog();
    },
  },

  async created() {
    await this.getInfoArtist();
  },
};
</script>

<style lang="scss" scoped>
.card {
  padding: 30px;
  .titleArtits {
    & > h3 {
      margin-top: 10px;
    }
  }
}
</style>
