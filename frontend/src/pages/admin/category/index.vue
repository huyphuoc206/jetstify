<template>
  <v-layout>
    <v-row>
      <v-col cols="12">
        <v-card class="ml-5 mr-5">
          <v-app-bar dark color="#2C3A47">
            <v-btn icon>
              <v-icon>mdi-format-list-bulleted-type</v-icon>
            </v-btn>
            <v-toolbar-title>Category</v-toolbar-title>
          </v-app-bar>
          <v-container>
            <app-confirm
              title="Delete Category"
              message="Are you sure delete this category?"
              :show="confirmDelete"
              :agree="agree"
              @closeConfirm="confirmDelete = false"
            />
            <category-details
              :show="showDialog"
              @closeDialog="showDialog = false"
            />
            <v-data-table
              :headers="headers"
              :items="categories"
              class="elevation-1"
            >
              <template v-slot:top>
                <v-toolbar flat>
                  <v-spacer></v-spacer>
                  <v-btn dark depressed color="pink" @click="openDetails"
                    >New Item</v-btn
                  >
                </v-toolbar>
              </template>
              <template v-slot:[`item.createdDate`]="{ item }">
                {{ moment(item.createdDate).format(dateFormat) }}
              </template>
              <template v-slot:[`item.updatedDate`]="{ item }">
                {{ moment(item.updatedDate).format(dateFormat) }}
              </template>
              <template v-slot:[`item.actions`]="{ item }">
                <v-btn icon color="blue" @click="openDetails(item)">
                  <v-icon> mdi-pencil </v-icon>
                </v-btn>
                <v-btn icon color="red" @click="deleteItem(item)">
                  <v-icon> mdi-delete </v-icon>
                </v-btn>
              </template>
            </v-data-table>
          </v-container>
        </v-card>
      </v-col>
    </v-row>
  </v-layout>
</template>
<script>
import AppConfirm from "@/components/confirm";
import CategoryDetails from "./category-details.vue";
import { mapGetters, mapActions } from "vuex";
import { DATE_FORMAT } from "@/core/constants";

export default {
  name: "AdminCategory",

  components: {
    AppConfirm,
    CategoryDetails,
  },

  data: () => ({
    headers: [
      { text: "Category Code", value: "code" },
      { text: "Category Name", value: "name" },
      { text: "Created Date", value: "createdDate", align: "center" },
      { text: "Updated Date", value: "updatedDate", align: "center" },
      { text: "Actions", value: "actions", sortable: false, align: "center" },
    ],
    confirmDelete: false,
    showDialog: false,
    selectedDeleteId: -1,
    dateFormat: DATE_FORMAT,
  }),

  computed: {
    ...mapGetters("category", ["categories"]),
  },

  methods: {
    ...mapActions("category", [
      "getCategories",
      "getCategoryDetails",
      "deleteCategory",
    ]),

    async agree() {
      await this.deleteCategory(this.selectedDeleteId);
    },

    async openDetails({ id }) {
      const { success, message } = await this.getCategoryDetails(id);
      if (success) {
        this.showDialog = true;
      } else {
        this.$notice.error(message);
      }
    },

    deleteItem({ id }) {
      this.confirmDelete = true;
      this.selectedDeleteId = id;
    },
  },

  async created() {
    await this.getCategories();
  },
};
</script>