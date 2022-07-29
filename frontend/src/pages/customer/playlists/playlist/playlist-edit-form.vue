<template>
  <v-row justify="center">
    <v-dialog v-model="toggleDialog" persistent max-width="600px">
      <v-card>
        <v-card-title>
          <h3 class="display-1 font-weight-bold">Profile details</h3>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-form ref="formProfile" v-model="isValidProfileForm">
                  <v-row>
                    <v-col cols="12" sm="5">
                      <v-avatar tile class="ms-8" size="150">
                        <v-img
                          v-if="checkAvatar"
                          :src="avatar"
                          alt="avatar"
                        ></v-img>

                        <v-icon v-else dark size="50"> fa-thin fa-music</v-icon>
                      </v-avatar>
                      <v-file-input
                        :rules="rules"
                        @change="handleFileUpload"
                        accept="image/png, image/jpeg,  image/jpg"
                        placeholder="Pick an thumbnail"
                        label="Thumbnail"
                      ></v-file-input>
                    </v-col>
                    <v-col cols="12" sm="7">
                      <v-text-field
                        v-model="fullNamePlayList"
                        label="Name"
                        placeholder="Add display name"
                        outlined
                        :rules="fullNameRules"
                        @keypress.enter="handleEditProfile()"
                      ></v-text-field>
                      <v-textarea
                        v-model="descriptionPlayList"
                        outlined
                        name="input-7-4"
                        label="Description"
                        :value="descriptionPlayList"
                      ></v-textarea>
                      <v-btn
                        class="float-right"
                        rounded
                        color="primary"
                        dark
                        @click="handleEditProfile()"
                        >Save</v-btn
                      >
                    </v-col>
                  </v-row>
                </v-form>
              </v-col>

              <v-col cols="12">
                <small class="white--text font-weight-bold"
                  >By continuing, you agree to allow Jetstify to access the
                  images you have selected for upload. Please make sure you have
                  permission to upload images.</small
                >
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="handleEdit"> Close </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import { jsonToFormData } from "@/utils/rest-utils";
import { mapActions, mapGetters } from "vuex";
import { $rest } from "@/core/rest-client";
// import userStore from "@/store/user";

export default {
  name: "UserEditForm",

  data: () => ({
    dialog: false,
    isValidProfileForm: false,
    flagAvatar: true,
    flagName: true,
    linkAvatar: "",
    nameAccount: "",
    description: null,
    fileAvatar: null,
    rules: [
      (value) =>
        !value ||
        value.size < 3000000 ||
        "Avatar size should be less than 3 MB!",
    ],

    fullNameRules: [(v) => (!!v && !!v.trim()) || "Full name is required"],
  }),

  computed: {
    ...mapGetters("playlist", ["toggleDialog", "playlist"]),

    checkAvatar() {
      if (this.flagAvatar) {
        return !!this.playlist.thumbnail;
      }
      return !!this.linkAvatar;
    },

    avatar: {
      get() {
        return this.linkAvatar ? this.linkAvatar : this.playlist.thumbnail;
      },

      set(newValue) {
        if (newValue === null) {
          this.flagAvatar = true;
        } else {
          this.flagAvatar = false;
          this.linkAvatar = newValue;
        }
      },
    },

    fullNamePlayList: {
      get() {
        return this.nameAccount ? this.nameAccount : this.playlist.namePlaylist;
      },

      set(newValue) {
        if (newValue === "") {
          this.nameAccount = " ";
        } else this.nameAccount = newValue;
      },
    },

    descriptionPlayList: {
      get() {
        return this.description || this.description === ""
          ? this.description
          : this.playlist.description;
      },

      set(newValue) {
        this.description = newValue;
      },
    },
  },

  methods: {
    ...mapActions("playlist", ["setToggleDialog", "getPlaylistById"]),
    // ...mapActions("auth", ["updateUserInfo"]),

    handleEdit() {
      this.setToggleDialog();
      this.resetFormClose();
    },

    handleFileUpload(files) {
      let imgUrl;
      if (files) {
        this.fileAvatar = files;
        imgUrl = URL.createObjectURL(files);
      } else {
        this.fileAvatar = new File([""], "");
      }
      this.avatar = imgUrl;
    },

    async handleEditProfile() {
      this.$refs.formProfile.validate();
      if (!this.isValidProfileForm) {
        return;
      }

      const jsonObject = {
        fileImg: this.fileAvatar,
        playlistRequest: JSON.stringify({
          name: (this.nameAccount
            ? this.nameAccount
            : this.playlist.namePlaylist
          ).trim(),
          description: (this.description || this.description === ""
            ? this.description
            : this.playlist.description
          ).trim(),
        }),
      };

      const idPlaylist = this.playlist.idPlaylist;

      const formData = jsonToFormData(jsonObject);

      const { success, message } = await $rest.upload(
        `/playlist/${idPlaylist}`,
        formData
      );

      if (success) {
        this.handleEdit();
        await this.getPlaylistById(idPlaylist);
      } else {
        this.$notice.error(message);
      }
    },

    resetFormClose() {
      this.fullNamePlayList = null;
      this.avatar = null;
      this.descriptionPlayList = null;
      this.fileAvatar = null;
    },
  },
};
</script>

<style lang="scss" scoped></style>
