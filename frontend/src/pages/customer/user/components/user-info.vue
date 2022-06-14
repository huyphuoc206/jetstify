<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img height="320px">
          <v-card class="card d-flex">
            <v-avatar class="profile" color="grey" size="200">
              <v-img :src="userInfo.avatar"></v-img>
            </v-avatar>
            <v-card-title class="white--text d-block titleArtits">
              <h3 class="mb-7 font-weight-bold">File</h3>
              <h1 class="display-3 font-weight-bold" @click="handleEdit">
                {{ userInfo.fullName }}
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
  name: "UserInfo",

  computed: {
    ...mapGetters("user", ["userInfo"]),
  },

  methods: {
    ...mapActions("user", ["getInfoUser", "setToggleDialog"]),

    handleEdit() {
      this.setToggleDialog();
    },
  },

  async created() {
    await this.getInfoUser();
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
