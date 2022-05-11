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
              <v-col cols="12" md="6">
                <v-text-field
                  required
                  v-model="selected.code"
                  label="Category Code"
                  :rules="codeRules"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  required
                  v-model="selected.name"
                  label="Category Name"
                  :rules="nameRules"
                ></v-text-field>
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
  name: "AdminCategory",

  props: {
    formTitle: {
      type: String,
      default: "New Category",
    },
    show: {
      type: Boolean,
      default: false,
    },
  },

  data: () => ({
    isValidForm: false,
    nameRules: [(v) => !!v || "Name is required"],
    codeRules: [(v) => !!v || "Code is required"],
  }),

  computed: {
    ...mapGetters("category", ["selected"]),
    title() {
      return this.selected.id ? "Edit Category" : "New Category";
    },
  },

  methods: {
    ...mapActions("category", ["saveCategory", "getCategories"]),

    async save() {
      this.$refs.form.validate();
      if (!this.isValidForm) {
        return;
      }
      await this.saveCategory();
    },

    cancel() {
      this.$emit("closeDialog");
    },
  },

  watch: {
    show() {
        !this.selected.id && this.$refs.form.reset()
    }
}
};
</script>

