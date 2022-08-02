<template>
  <v-container class="mx-5">
    <v-row align="center" justify="center">
      <v-col cols="auto">
        <v-menu
          v-model="fromMenuUsers"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              :value="fromDateUsers"
              label="From Month"
              prepend-icon="mdi-calendar"
              color="#81858a"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            v-model="fromDateUsers"
            type="month"
            no-title
            :max="toDateUsers"
            @input="fromMenuUsers = false"
          />
        </v-menu>
      </v-col>

      <v-col cols="auto">
        <v-menu
          v-model="toMenuUsers"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              :value="toDateUsers"
              label="To Month"
              prepend-icon="mdi-calendar"
              color="#81858a"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            v-model="toDateUsers"
            type="month"
            no-title
            :min="fromDateUsers"
            @input="toMenuUsers = false"
          />
        </v-menu>
      </v-col>
      <v-col cols="auto">
        <v-btn color="pink" @click="searchUsersChart">Search</v-btn>
      </v-col>
    </v-row>
    <v-row>
      <GChart
        style="width: 100%"
        type="ColumnChart"
        :data="chartDataUser"
        :options="chartOptionsUsers"
        :resizeDebounce="500"
      />
    </v-row>
    <v-row align="center" justify="center">
      <v-col cols="auto">
        <v-menu
          v-model="fromMenuSongs"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              :value="fromDateSongs"
              label="From Month"
              prepend-icon="mdi-calendar"
              color="#81858a"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            v-model="fromDateSongs"
            no-title
            type="month"
            :max="toDateSongs"
            @input="fromMenuSongs = false"
          />
        </v-menu>
      </v-col>

      <v-col cols="auto">
        <v-menu
          v-model="toMenuSongs"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              :value="toDateSongs"
              label="To Month"
              prepend-icon="mdi-calendar"
              color="#81858a"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            v-model="toDateSongs"
            no-title
            type="month"
            :min="fromDateSongs"
            @input="toMenuSongs = false"
          />
        </v-menu>
      </v-col>
      <v-col cols="auto">
        <v-btn color="pink" @click="searchSongsChart">Search</v-btn>
      </v-col>
    </v-row>
    <v-row>
      <GChart
        style="width: 100%"
        type="ColumnChart"
        :data="chartDataSong"
        :options="chartOptionsSongs"
        :resizeDebounce="500"
      />
    </v-row>
  </v-container>
</template>

<script>
const BASE_URL = "/admin/dashboard"
import { GChart } from "vue-google-charts/legacy";
import * as moment from "moment";

export default {
  name: "AdminHome",
  components: {
    GChart,
  },
  data() {
    return {
      chartDataUser: [
        ["Year-Month", "Total"],
        ["2014", 1000],
      ],
      chartOptionsUsers: {
        title: "Active Users Chart",
        height: 400,
        legend: { position: "bottom" },
        vAxis: {
          title: "",
        },
        colors: ["#33A14E"],
      },
      chartDataSong: [
        ["Year-Month", "Total"],
      ],
      chartOptionsSongs: {
        title: "Uploaded Songs Chart",
        height: 400,
        legend: { position: "bottom" },
        vAxis: {
          title: "",
        },
        colors: ["#33A14E"],
      },
      fromMenuUsers: false,
      toMenuUsers: false,
      fromDateUsers: moment().startOf("year").format("YYYY-MM"),
      toDateUsers: moment().endOf("year").format("YYYY-MM"),
      fromMenuSongs: false,
      toMenuSongs: false,
      fromDateSongs: moment().startOf("year").format("YYYY-MM"),
      toDateSongs: moment().endOf("year").format("YYYY-MM"),
    };
  },

  methods: {
    async searchUsersChart() {
      const { success, data, message } = await this.$rest.get(`${BASE_URL}/users-chart`, {
        fromMonth: this.fromDateUsers,
        toMonth: this.toDateUsers
      });

      if (success) {
        this.chartDataUser = [["Year-Month", "Total"]];
        data.forEach(e => this.chartDataUser.push([e.key, e.value]));
      } else {
        this.$notice.error(message);
      }
    },

    async searchSongsChart() {
      const { success, data, message } = await this.$rest.get(`${BASE_URL}/songs-chart`, {
        fromMonth: this.fromDateSongs,
        toMonth: this.toDateSongs
      });
      if (success) {
        this.chartDataSong = [["Year-Month", "Total"]];
        data.forEach(e => this.chartDataSong.push([e.key, e.value]));
      } else {
        this.$notice.error(message);
      }
    },
  },

  async created() {
    await this.searchUsersChart();
    await this.searchSongsChart();
  }
};
</script>
