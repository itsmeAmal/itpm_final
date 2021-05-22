/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.model;

/**
 *
 * @author Amal
 */
public class Room {

    private int roomId;
    private int roomType;
    private int roomCapacity;
    private int roomRelatedBuildingId;

    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the roomType
     */
    public int getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the roomCapacity
     */
    public int getRoomCapacity() {
        return roomCapacity;
    }

    /**
     * @param roomCapacity the roomCapacity to set
     */
    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    /**
     * @return the roomRelatedBuildingId
     */
    public int getRoomRelatedBuildingId() {
        return roomRelatedBuildingId;
    }

    /**
     * @param roomRelatedBuildingId the roomRelatedBuildingId to set
     */
    public void setRoomRelatedBuildingId(int roomRelatedBuildingId) {
        this.roomRelatedBuildingId = roomRelatedBuildingId;
    }

}
