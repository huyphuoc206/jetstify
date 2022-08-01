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
              label="From Date"
              prepend-icon="mdi-calendar"
              color="#81858a"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            v-model="fromDateUsers"
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
              label="To Date"
              prepend-icon="mdi-calendar"
              color="#81858a"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            v-model="toDateUsers"
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
              label="From Date"
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
              label="To Date"
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
        ["Year", "Sales", "Expenses", "Profit"],
        ["2014", 1000, 400, 200],
        ["2015", 1170, 460, 250],
        ["2016", 660, 1120, 300],
        ["2017", 1030, 540, 350],
      ],
      chartOptionsUsers: {
        title: "Active Users Chart",
        height: 400,
        legend: { position: "bottom" },
        vAxis: {
          title: "",
        },
        colors: ["#D3D3D3", "#FF8C00", "#BB8C00"],
      },
      chartDataSong: [
        ["Year", "Sales", "Expenses", "Profit"],
        ["2014", 1000, 400, 200],
        ["2015", 1170, 460, 250],
        ["2016", 660, 1120, 300],
        ["2017", 1030, 540, 350],
      ],
      chartOptionsSongs: {
        title: "Uploaded Songs Chart",
        height: 400,
        legend: { position: "bottom" },
        vAxis: {
          title: "",
        },
        colors: ["#D3D3D3", "#FF8C00", "#BB8C00"],
      },
      fromMenuUsers: false,
      toMenuUsers: false,
      fromDateUsers: moment().startOf("month").format("YYYY-MM-DD"),
      toDateUsers: moment().endOf("month").format("YYYY-MM-DD"),
      fromMenuSongs: false,
      toMenuSongs: false,
      fromDateSongs: moment().startOf("month").format("YYYY-MM-DD"),
      toDateSongs: moment().endOf("month").format("YYYY-MM-DD"),
    };
  },
};
</script>
