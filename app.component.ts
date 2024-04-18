import { Component, OnInit, ViewChild } from "@angular/core";
import {
  ITimelineItem,
  TimelineComponent,
  IItemTimeChangedEvent,
  TimelineViewMode,
  ITimelineZoom,
  DefaultZooms,
} from "angular-calendar-timeline";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
})
export class AppComponent implements OnInit {
  @ViewChild("timeline", { static: true }) timelineComponent: TimelineComponent;

  constructor() {
    this.timelineComponent = {} as TimelineComponent;
  }

  ngOnInit(): void {

  }

  items: ITimelineItem[] = [
    {
      startDate: new Date("2022-07-08T00:00:00"),
      endDate: new Date("2022-09-08T00:00:00"),
      id: 1,
      name: "Default item",
      canResizeLeft: true,
      canResizeRight: true,
      canDragX: true,
    },
    {
      startDate: new Date("2022-07-09T00:00:00"),
      endDate: new Date("2022-07-19T00:00:00"),
      id: 2,
      name: "Item with children",
      canResizeLeft: true,
      canResizeRight: true,
      canDragX: true,
    },
  ];

  zoomViewModes: ITimelineZoom[] = [
    {columnWidth: 45, viewMode: TimelineViewMode.Day},
    {columnWidth: 55, viewMode: TimelineViewMode.Month},
  ];

  ngAfterViewInit() : void {
    this.timelineComponent.changeZoom(this.timelineComponent.zooms[0]);
  }

  viewByMonth(): void {
    this.timelineComponent.changeZoom(this.timelineComponent.zooms[1]);
    console.log(`ZOOM IIIIIIIN METRICS: ${JSON.stringify(this.timelineComponent?.zoom)}`);
  }

  viewByDay(): void {
    this.timelineComponent.changeZoom(this.timelineComponent.zooms[0]);
    console.log(`ZOOM IIIIIIIN METRICS: ${JSON.stringify(this.timelineComponent?.zoom)}`);
  }

  scrollToToday(): void {
    this.timelineComponent?.zoomFullIn();
    this.timelineComponent?.attachCameraToDate(new Date());
  }

  zoomAndFitToContentMode(viewMode : number): void {
    // this.timelineComponent.
  }

  onItemTimeChanged(event: IItemTimeChangedEvent): void {
    const item = event.item;
    item.startDate = event.newStartDate ?? item.startDate;
    item.endDate = event.newEndDate ?? item.endDate;
    this.items = [...this.items];
  }

  getViewModeName(): string {
    switch (this.timelineComponent?.zoom?.viewMode) {
      case TimelineViewMode.Day:
        return "Day";
      case TimelineViewMode.Week:
        return "Week";
      case TimelineViewMode.Month:
        return "Month";
      default:
        return "Unknown";
    }
  }
}
