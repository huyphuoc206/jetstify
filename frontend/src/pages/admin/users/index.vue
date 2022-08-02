<template>
  <v-layout>
    <v-row>
      <v-col cols="12">
        <v-card class="ml-5 mr-5">
          <v-app-bar dark color="#2C3A47">
            <v-btn icon>
              <v-icon>mdi-format-list-bulleted-type</v-icon>
            </v-btn>
            <v-toolbar-title>Users</v-toolbar-title>
          </v-app-bar>
          <v-container>
            <app-confirm
              title="Delete User"
              message="Are you sure delete this user?"
              :show="confirmDelete"
              :agree="agree"
              @closeConfirm="confirmDelete = false"
            />
            <user-details
              :show="showDialog"
              @closeDialog="showDialog = false"
              @resetPage="resetPage"
              @resetSearch="resetSearch"
            />

            <v-data-table
              :headers="headers"
              :items="users"
              class="elevation-1"
              hide-default-footer
            >
              <template v-slot:top>
                <v-toolbar flat>
                  <v-row align="center">
                    <v-text-field
                      label="Email"
                      hide-details="auto"
                      v-model="searchEmail"
                    ></v-text-field>
                    <v-checkbox
                      class="ml-3 mt-9"
                      label="Active"
                      v-model="active"
                    ></v-checkbox>
                    <v-btn
                      class="ml-3"
                      depressed
                      color="pink"
                      @click="handleSearch"
                      >Search</v-btn
                    >
                  </v-row>
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
              </template>
            </v-data-table>
            <v-pagination
              dark
              v-model="page"
              @input="inputPage"
              :length="lengthPaging"
              :total-visible="7"
            ></v-pagination>
          </v-container>
        </v-card>
      </v-col>
    </v-row>
  </v-layout>
</template>
<script>
import AppConfirm from "@/components/confirm";
import UserDetails from "./user-details.vue";
import { mapGetters, mapActions } from "vuex";
import { DATE_FORMAT } from "@/core/constants";

export default {
  name: "UsersAdmin",

  components: {
    AppConfirm,
    UserDetails,
  },

  data: () => ({
    headers: [
      { text: "Email", value: "email" },
      { text: "Full Name", value: "fullName" },
      { text: "Created Date", value: "createdDate", align: "center" },
      { text: "Updated Date", value: "updatedDate", align: "center" },
      { text: "Actions", value: "actions", sortable: false, align: "center" },
    ],
    showDialog: false,
    dateFormat: DATE_FORMAT,
    page: 1,
    limit: 5,
    searchEmail: "",
    active: true,
  }),

  computed: {
    ...mapGetters("usersAdmin", ["users", "totalItems"]),
    lengthPaging() {
      return Math.ceil(this.totalItems / this.limit);
    },
  },

  methods: {
    ...mapActions("usersAdmin", ["getUsers", "getUsersDetails"]),

    async openDetails({ id }) {
      const { success, message } = await this.getUsersDetails(id);
      if (success) {
        this.showDialog = true;
      } else {
        this.$notice.error(message);
      }
    },

    async inputPage(page) {
      this.page = page;
      await this.getUsers({
        page: this.page,
        limit: this.limit,
        email: this.searchEmail,
        active: this.active,
      });
    },

    resetPage() {
      this.page = 1;
    },

    resetSearch() {
      console.log('hello');
      this.active = true;
      this.searchEmail = '';
    },

    async handleSearch() {
      this.resetPage();
      await this.getUsers({
        page: this.page,
        limit: this.limit,
        email: this.searchEmail,
        active: this.active,
      });
    },
  },

  async created() {
    await this.getUsers({
      page: this.page,
      limit: this.limit,
      email: "",
      active: true,
    });
  },
};
</script>