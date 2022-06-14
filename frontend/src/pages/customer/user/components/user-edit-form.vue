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
                      <v-avatar class="ms-8" size="150">
                        <img :src="avatar" alt="avatar" />
                      </v-avatar>
                      <v-file-input
                        :rules="rules"
                        @change="handleFileUpload"
                        accept="image/png, image/jpeg,  image/jpg"
                        placeholder="Pick an avatar"
                        label="Avatar"
                        @keypress.enter="handleEditProfile()"
                      ></v-file-input>
                    </v-col>
                    <v-col cols="12" sm="7">
                      <v-text-field
                        required
                        v-model="userInfo.fullName"
                        label="Name"
                        placeholder="Add display name"
                        outlined
                        :rules="fullNameRules"
                        @keypress.enter="handleEditProfile()"
                      ></v-text-field>
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
          <v-btn color="blue darken-1" text @click="dialog = false">
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import { jsonToFormData } from "@/utils/rest-utils";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "UserEditForm",

  data: () => ({
    dialog: false,
    isValidProfileForm: false,
    linkAvatar: "",
    fileAvatar: {},
    rules: [
      (value) =>
        !value ||
        value.size < 3000000 ||
        "Avatar size should be less than 3 MB!",
    ],

    fullNameRules: [(v) => !!v || "Full name is required"],
  }),

  computed: {
    ...mapGetters("user", ["toggleDialog", "userInfo"]),

    avatar: {
      get() {
        return this.linkAvatar ? this.linkAvatar : this.userInfo.avatar;
      },

      set(newValue) {
        this.linkAvatar = newValue;
      },
    },
  },

  methods: {
    ...mapActions("user", ["setToggleDialog", "editInfoUser"]),

    handleEdit() {
      this.setToggleDialog();
    },

    handleFileUpload(files) {
      if (files) {
        this.fileAvatar = files;
        const imgUrl = URL.createObjectURL(files);
        this.avatar = imgUrl;
      }
    },

    async handleEditProfile() {
      this.$refs.formProfile.validate();
      if (!this.isValidProfileForm) {
        return;
      }

      const jsonObject = {
        fileImg: this.fileAvatar,
        userRequest: JSON.stringify({ fullName: this.userInfo.fullName }),
      };

      const formData = jsonToFormData(jsonObject);

      // console.log(this.userInfo.avatar);

      const { success, message } = await this.editInfoUser(formData);
      if (success) {
        this.resetForm();
        this.setToggleDialog();
      } else {
        this.$notice.error(message);
      }
    },

    resetForm() {
      this.$refs.formProfile.reset();
    },
  },
};
</script>

<style lang="scss" scoped></style>
