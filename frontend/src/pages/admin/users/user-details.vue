<template>
  <v-dialog
    :value="show"
    max-width="500px"
    @keydown.esc="cancel"
    @click:outside="cancel"
  >
    <v-card>
      <v-card-title>
        <span class="text-h5">{{ title }}</span>
      </v-card-title>

      <v-card-text>
        <v-container>
          <v-form ref="form" v-model="isValidForm">
            <v-row>
              <v-col cols="12">
                <v-text-field
                  required
                  v-model="selected.email"
                  label="Email"
                  disabled
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  required
                  v-model="selected.fullName"
                  label="Full Name"
                  :rules="fullNameRules"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-checkbox label="Active" v-model="selected.active"></v-checkbox>
              </v-col>
            </v-row>
          </v-form>
        </v-container>
      </v-card-text>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="primary darken-1" text @click="cancel"> Cancel </v-btn>
        <v-btn color="primary darken-1" @click="save"> Save </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "UserAdmin",

  props: {
    formTitle: {
      type: String,
      default: "User Details",
    },
    show: {
      type: Boolean,
      default: false,
    },
  },

  data: () => ({
    isValidForm: false,
    fullNameRules: [(v) => !!v || "Full Name is required"],
  }),

  computed: {
    ...mapGetters("usersAdmin", ["selected"]),
    title() {
      return "Edit User";
    },
  },

  methods: {
    ...mapActions("usersAdmin", ["saveUsers"]),

    async save() {
      this.$refs.form.validate();
      if (!this.isValidForm) {
        return;
      }
      await this.saveUsers();
      this.$emit("resetPage");
      this.$emit("resetSearch");
    },

    cancel() {
      this.$emit("closeDialog");
    },
  },

  watch: {
    show() {
      !this.selected.id && this.$refs.form && this.$refs.form.reset();
    },
  },
};
</script>

