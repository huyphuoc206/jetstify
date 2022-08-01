<template>
  <v-row justify="center">
    <v-dialog
      v-if="toggleDialogCreate"
      v-model="toggleDialogCreate"
      persistent
      max-width="600px"
    >
      <v-card>
        <v-card-title>
          <h3 class="display-1 font-weight-bold">Upload music</h3>
        </v-card-title>

        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-form ref="formProfile" v-model="isValidProfileForm">
                  <v-row>
                    <v-col cols="12" sm="5">
                      <v-avatar class="ms-8" tile size="150" color="grey">
                        <v-img  :src="avatar"  alt="avatar"></v-img>
                        <!-- <span
                          v-else
                          class="white--text text-h2 mt font-weight-regular"
                          >{{ defaultAvatar }}</span
                        > -->
                      </v-avatar>

                      <v-file-input
                        :rules="rules"
                        @change="handleFileUpload"
                        accept="image/png, image/jpeg,  image/jpg"
                        placeholder="Pick an thumbnail"
                        label="Thumbnail"
                      ></v-file-input>

                      <v-file-input
                        :rules="SongRules"
                        @change="handleFileSongUpload"
                        accept="audio/mp3, audio/mp4"
                        placeholder="Choose your song"
                        label="Song"
                      ></v-file-input>
                    </v-col>
                    <v-col cols="12" sm="7">
                      <v-text-field
                        v-model="fullNameSong"
                        label="Song name"
                        placeholder="Add song name"
                        outlined
                        :rules="fullNameRules"
                        @keypress.enter="handleUploadSong()"
                      ></v-text-field>

                      <v-combobox
                        @change="handleCategory"
                        :rules="categoryRules"
                        :items="
                          categoriesClient.map((e) => ({
                            text: e.name,
                            value: e.id,
                          }))
                        "
                        color="success"
                      >
                      </v-combobox>

                      <v-btn
                        class="float-right"
                        rounded
                        color="primary"
                        dark
                        @click="handleUploadSong()"
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

export default {
  name: "ArtistSettingCreateSong",

  data: () => ({
    dialog: false,
    isValidProfileForm: false,
    flagAvatar: true,
    flagName: true,
    linkAvatar: "",
    nameSong: "",
    fileAvatar: null,
    fileSong: null,
    category: -1,
    rules: [
      (value) =>
        (!!value && value.size < 3000000) ||
        "Thumbnail size should be less than 3 MB!",
    ],

    SongRules: [
      (value) =>
        (!!value && value.size < 10000000) ||
        "Song size should be less than 5 MB!",
    ],

    fullNameRules: [(v) => !!v.trim() || "Song name is required"],
    categoryRules: [(v) => (!!v && !!v.value) || "Category is required"],
  }),

  computed: {
    ...mapGetters("artistSetting", ["artistInfo", "toggleDialogCreate"]),

    ...mapGetters("category", ["categoriesClient"]),

    defaultActiveCategory() {
      return this.categoriesClient[0] ? this.categoriesClient[0].id : "";
    },

    avatar: {
      get() {
        return this.linkAvatar ? this.linkAvatar : this.artistInfo.avatar;
      },

      set(newValue) {
          this.linkAvatar = newValue;      
      },
    },

    fullNameSong: {
      get() {
        return this.nameSong;
      },

      set(newValue) {
        if (newValue === "") {
          this.nameSong = " ";
        } else {
          this.nameSong = newValue;
        }
      },
    },
  },

  methods: {
    ...mapActions("artistSetting", [
      "setToggleDialogCreateSong",
      "getInfoArtist",
    ]),

    ...mapActions("category", ["getCategoriesToClient"]),

    handleEdit() {
      this.setToggleDialogCreateSong();
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

    handleFileSongUpload(files) {
      if (files) {
        this.fileSong = files;
      } else {
        this.fileSong = new File([""], "");
      }
    },

    handleCategory(value) {
      this.category = value.value;
    },

    async handleUploadSong() {
      this.$refs.formProfile.validate();
      if (!this.isValidProfileForm) {
        return;
      }

      const jsonObject = {
        fileImg: this.fileAvatar,
        fileMp3: this.fileSong,
        songRequest: JSON.stringify({
          name: (this.nameSong
            ? this.nameSong
            : this.artistInfo.nickName
          ).trim(),
          categoryId:
            this.category === -1 ? this.categoriesClient[0].id : this.category,
        }),
      };

      const formData = jsonToFormData(jsonObject);

      const { success, message } = await $rest.upload("/song", formData);

      if (success) {
        this.handleEdit();
        await this.getInfoArtist();
        this.$notice.success('Upload music successfully');
      } else {
        this.$notice.error(message);
      }
    },

    resetFormClose() {
      this.fullNameSong = "";
      this.avatar = null;
      this.fileSong = null;
      this.categoryId = -1;
    },
  },

  async created() {
    await this.getCategoriesToClient();
  },
};
</script>
